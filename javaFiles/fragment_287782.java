package com.mybatis;

import java.util.Map;
import java.util.logging.Logger;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class SqlProvider {

    public String sqlProvider(Map<String, Object> map){
        Logger.getLogger(SqlProvider.class.getName()).info("select * from student where id="+map.get("0"));
        return "select * from student where id="+map.get("0");
    }

    public String findById(@Param("id") int id){
        return new SQL(){{
            SELECT("id,name,info");
            FROM("student");
            WHERE("id="+id);
        }
            }.toString();
    }
}