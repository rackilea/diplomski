@FilterDef(name="GLOBAL_FILTER",   parameters = {@ParamDef(name="sessParam", type="string")}, 
                                    defaultCondition = "sessParam = :sessParam")

package com.company.app.entity;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.ParamDef;