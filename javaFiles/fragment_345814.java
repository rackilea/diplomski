<coordinator-app name="FILE_CHECK" frequency="1440" start="2009-02-01T00:00Z" end="2009-02-07T00:00Z" timezone="UTC" xmlns="uri:oozie:coordinator:0.1">
   <datasets>
      <dataset name="datafile" frequency="60" initial-instance="2009-01-01T00:00Z" timezone="UTC">
         <uri-template>hdfs://<URI>:<PORT>/data/feed/${YEAR}/${MONTH}/${DAY}/${HOUR}</uri-template>
      </dataset>
   </datasets>
   <input-events>
      <data-in name="coorddatafile" dataset="datafile">
          <start-instance>${coord:current(-23)}</start-instance>
          <end-instance>${coord:current(0)}</end-instance>
      </data-in>
   </input-events>
   <action>
      <workflow>
         <app-path>hdfs://<URI>:<PORT>/workflows</app-path>
      </workflow>
   </action>     
</coordinator-app>