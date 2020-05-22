<update id="update_company_details" parameterType="map">
        UPDATE Company
        <set>
            <if test="name_value!= null">
                name = #{name_value},
            </if>
            <if test="headQrtr_value!= null">
                headQrtr= #{headQrtr_value},
            </if>
            <if test="ceo_value!= null">
                ceo= #{ceo_value},
            </if>
        </set>
        WHERE company_id= #{company_id_value}
    </update>