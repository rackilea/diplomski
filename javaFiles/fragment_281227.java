<measure name="nbreVehicule_measure" class="java.lang.String">
   <measureExpression><![CDATA[$F{nbreVehicule}]]></measureExpression>
</measure>

<columnGroup name="nbreVehicule" height="66">
   <bucket class="java.lang.Integer">
     <bucketExpression><![CDATA[$F{myOrderByField}]]></bucketExpression>
   </bucket>
   ....
   <textFieldExpression><![CDATA[$V{nbreVehicule_measure}]]></textFieldExpression>
   .....
</columnGroup>