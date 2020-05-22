//set params to find out counter
 groupinfo = "datastore";
         nameinfo="datastoreIops";
         rollup = "average";
      //set interval    
Calendar startTime = (Calendar) curTime.clone(); 
startTime.add(Calendar.MINUTE, -5); 
PerformanceManager perfMgr = si.getPerformanceManager();
PerfProviderSummary summary = perfMgr.queryPerfProviderSummary(myhost);
int perfInterval = summary.getRefreshRate();
//get performance counters
PerfCounterInfo[] perfCounters = perfMgr.getPerfCounter();
int counter_id = 0;
//find id of right counter by iterating
for (int i = 0; i < perfCounters.length; i++) {
PerfCounterInfo perfCounterInfo = perfCounters[i];
String perfCounterString = perfCounterInfo.getNameInfo().getLabel() + " (" + perfCounterInfo.getGroupInfo().getKey() + ") in "
        + perfCounterInfo.getUnitInfo().getLabel() + " (" + perfCounterInfo.getStatsType().toString() + ")";
if (perfCounterInfo.getGroupInfo().getKey().equalsIgnoreCase(groupinfo) 
&& perfCounterInfo.getNameInfo().getKey().equalsIgnoreCase(nameinfo) 
&&  perfCounterInfo.getRollupType().name().equalsIgnoreCase(rollup) )
{
counter_id =    perfCounterInfo.getKey();
break;  
}
}
int i3;
PerfMetricId[] queryAvailablePerfMetric = perfMgr.queryAvailablePerfMetric(myhost, null, null, perfInterval);
ArrayList<PerfMetricId> list = new ArrayList<PerfMetricId>();
for (int i2 = 0; i2 < queryAvailablePerfMetric.length; i2++) {
PerfMetricId perfMetricId = queryAvailablePerfMetric[i2];
if (counter_id == perfMetricId.getCounterId()) {
    list.add(perfMetricId);
}
}
PerfMetricId[] pmis = list.toArray(new PerfMetricId[list.size()]);
PerfQuerySpec qSpec = new PerfQuerySpec();
qSpec.setEntity(myhost.getMOR());
qSpec.setMetricId(pmis);
qSpec.setStartTime(startTime);
qSpec.setEndTime(curTime);
qSpec.intervalId = perfInterval;

PerfEntityMetricBase[] pembs = perfMgr.queryPerf(new PerfQuerySpec[] { qSpec });

PerfEntityMetricBase val = pembs[0];
PerfEntityMetric pem = (PerfEntityMetric) val;
PerfMetricSeries[] vals = pem.getValue();

JSONObject perfout = new JSONObject();

for (int instanceid =0; vals != null && instanceid <vals.length;instanceid++ ) {

PerfMetricIntSeries val1 = (PerfMetricIntSeries) vals[instanceid];
String InstanceName = val1.getId().instance;
if (InstanceName.equals("")){
    InstanceName="Total_"+instanceid;
}

long[] longs = val1.getValue();
long last_longs_value = longs[longs.length-1];
try {
perfout.put(InstanceName.replace(".", "-"), last_longs_value);
} catch (JSONException e) {
e.printStackTrace();
}
}
System.out.println(perfout);