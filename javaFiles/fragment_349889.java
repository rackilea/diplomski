<pig>
            <job-tracker>${jobTracker}</job-tracker>
            <name-node>${nameNode}</name-node>
            <prepare>
                <delete path="${nameNode}/user/${wf:user()}/${examplesRoot}/output-data/pig"/>
            </prepare>
            <configuration>
                <property>
                    <name>mapred.job.queue.name</name>
                    <value>${queueName}</value>
                </property>
            </configuration>
            <script>id.pig</script>
            <param>INPUT=/user/${wf:user()}/${examplesRoot}/input-data/text</param>
            <param>OUTPUT=/user/${wf:user()}/${examplesRoot}/output-data/pig</param>
        </pig>