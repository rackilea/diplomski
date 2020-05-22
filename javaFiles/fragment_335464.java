SummaryOutage summaryOutage = new ObjectMapper().readValue(response, SummaryOutage.class);

        double uptime = 0d;
        double downtime = 0d;
        double unknown = 0d;

        for(SummaryOutage.Summary.State state :summaryOutage.summary.states){
            if(state.status.equals("up")){
                uptime =  uptime + (state.timeto - state.timefrom);
            }else if (state.status.equals("down")){
                downtime  =  downtime + (state.timeto - state.timefrom);
            }else if (state.status.equals("unknown")){
                unknown  =  unknown + (state.timeto - state.timefrom);
            }

        }

        double totalTime = uptime + downtime + unknown;
        if(totalTime > 0) {

            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            String numberAsString = decimalFormat.format(100 *( (uptime + unknown) / totalTime));

            return numberAsString;

        }