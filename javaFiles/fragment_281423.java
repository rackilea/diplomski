<!-- hibernate search configuration -->
            <!-- index root folder location -->
            <prop key="hibernate.search.default.indexBase">${env.ftindex.location.root}/${datasource.database}/${ftindex.folder}</prop>
            <!-- global analyzer -->
            <prop key="hibernate.search.analyzer">custom_analyzer</prop>
            <!-- asynchronous indexing for performance considerations -->
            <prop key="org.hibernate.worker.execution">async</prop>
            <!-- max number of indexing operation to be processed asynchronously (before session flush) to avoid OutOfMemoryException -->
            <prop key="hibernate.search.worker.buffer_queue.max">100</prop>