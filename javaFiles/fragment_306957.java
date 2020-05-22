<update id="createNewTable" parameterType="String" > 

    CREATE TABLE IF NOT EXISTS #{value} ( 
            id             INT UNSIGNED        AUTO_INCREMENT PRIMARY KEY, 
    ENGINE=InnoDB DEFAULT CHARSET=utf8; 

</update >