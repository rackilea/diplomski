in Java,

        Map paramMap = new HashMap();
        paramMap.put("productTypes", productTypes);
        sqlMapClient.queryForList("getProducts", paramMap);
in xml,

<select id="getProducts" parameterClass="java.util.Map" 
resultClass="Product">
SELECT * FROM Products
<dynamic prepend="WHERE productType IN ">
<iterate property="productTypes"
    open="(" close=")"
    conjunction=",">
    productType=#productType#
 </iterate>
 </dynamic>
 </select>