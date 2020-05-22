<coordinator-app end="${endTime}" frequency="${frequency}" name="sample_update" start="${startTime}" timezone="${timezone}" xmlns="uri:oozie:coordinator:0.2">

<controls>

        <timeout>5</timeout>

        <concurrency>1</concurrency>

</controls>

<action>

<workflow>

<app-path>wasb://xxx@yyy.blob.core.windows.net/user/hdp/ooziejava/workflow.xml</app-path>

</workflow>

</action>

</coordinator-app>