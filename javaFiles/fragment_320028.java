<authentication-manager>
       <authentication-provider>
        <jdbc-user-service data-source-ref="dataSource"
           users-by-username-query="select USERNAME as &quot;username&quot;,PASSWORD as &quot;password&quot;,1 as &quot;enabled&quot; from USER_APP where username = 'a'"
        />
</authentication-manager>