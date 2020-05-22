<select id="getLastMassPaymentRecords" resultType="MassPaymentFile" parameterType="map" >
       <![CDATA[
        SELECT
                file_id,
                file_name,
                record_count,
                error_count,
                status,
                user_id
        FROM mass_payment_protocol
       WHERE user_id=#{user_id} AND rownum<=#{count}
       ORDER BY created desc
       ]]>
    </select>