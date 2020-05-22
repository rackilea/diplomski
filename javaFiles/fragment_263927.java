//service call
    public Map<String, Object> callProcedure(String param){

            Map<String, Object> map = new HashMap<String, Object>();
            Integer privilegesCount = 0;
            map.put("p_id_grupo_familiar", Integer.valueOf(param));
            asociadoMapper.callProcedure(map);

            return map;
        }
    //mapper
        @Select(value = AsociadoQueries.getDocumentoAsociadoCall)
        @Options(statementType = StatementType.CALLABLE)
        void callProcedure(Map<String,Object> params);

// Call statement

public static final String getDocumentoAsociadoCall = "{ CALL consultas_generales.get_detalle_cliente_gf(" +
            "#{p_id_grupo_familiar,  jdbcType=NUMERIC ,javaType=java.lang.Integer ,mode=IN}," +
            "#{p_tipo_cliente, jdbcType=NUMERIC,javaType=java.lang.Integer ,mode=OUT,},"+
            "#{p_codigo_cliente,  jdbcType=NUMERIC ,javaType=java.lang.Integer ,mode=OUT},"+
            "#{p_nombre_cliente,  jdbcType=VARCHAR ,javaType=java.lang.String ,mode=OUT},"+
            "#{p_cuit_cliente,  jdbcType=VARCHAR ,javaType=java.lang.String ,mode=OUT},"+
            "#{p_cuit_rp,  jdbcType=VARCHAR ,javaType=java.lang.String ,mode=OUT},"+
            "#{p_razon_social_rp,  jdbcType=VARCHAR ,javaType=java.lang.String ,mode=OUT},"+
            "#{p_domicilio, jdbcType=VARCHAR ,javaType=java.lang.String ,mode=OUT}"+
            ")}";