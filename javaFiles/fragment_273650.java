package com.example;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
// Other imports

@Repository
public interface PersonRepository {
    public List<Type1> getAsType1(@Param("searchParams") SearchParams searchParams);
    public List<Type2> getAsType2(@Param("searchParams") SearchParams searchParams);
}