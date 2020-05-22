package com.mybatis;    
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

/*
*
*Stu is an entity map to your table in db
*
*/
@Mapper
public interface StuMapper {

    @SelectProvider(type=SqlProvider.class,method="sqlProvider")
    public Stus sqlProvider(Map<String, Object> map);

    @SelectProvider(type=SqlProvider.class,method="findById")
    public Stus findById_(@Param("id") int id);

}