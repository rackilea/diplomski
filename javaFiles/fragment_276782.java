<insert id="insertServiceMappings" parameterType="java.util.List">
    <foreach collection="list" item="channel" index="index" >
        INSERT INTO tva_upselladmin_channel (id,source_id, service_id, name)
              VALUES ( #{id}, #{channel.sourceId}, #{channel.serviceId}, #{channel.name});
    </foreach>
</insert>