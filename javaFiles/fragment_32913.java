select id="addHardwareList" 
statementType="CALLABLE" parameterType="java.util.HashMap">
      {
             call P_HW_SW_CRUD.SAVE_HARDWARE_INVENTORY(
             #{pDataIn,javaType=Object,
jdbcType=ARRAY,jdbcTypeName=TAB_IDESK_HW_INFO,
 mode=IN,typeHandler=com.tristar.idesk.mybatis.mapper.HardwareInventoryHandler}
             #{pMsgCodeOut,javaType=Long,jdbcType=DECIMAL,mode=OUT}
         )
     }