<action name="spark-210e">
    <spark xmlns="uri:oozie:spark-action:0.2">
        <job-tracker>${jobTracker}</job-tracker>
        <name-node>${nameNode}</name-node>
        <master>yarn</master>
        <mode>cluster</mode>
        <name>CleanseData</name>
          <class>com.data.CleanseData</class>
        <jar>JCleanseData.jar</jar>
          <spark-opts>--driver-memory 2G --executor-memory 2G --num-executors 10 --files hive-site.xml</spark-opts>
          <arg>yarn</arg>
          <arg>[someArg1]</arg>
          <arg>[someArg2]</arg>
        <file>lib/JCleanseData.jar#JCleanseData.jar</file>        
    </spark>
    <ok to="[nextAction]"/>
    <error to="Kill"/>
</action>