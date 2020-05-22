SELECT
    m.id AS meter_id,
    m.meter_num AS meter_number,
    IF(
        l.split = 0,
        m.route_id,
        CONCAT(
            CAST(m.route_id AS CHAR),
            CAST(l.split AS CHAR)
        )
    ) AS route_id,
    m.sequence AS sequence_number,
    m.address,
    m.location,
    m.location_2,
    m.location_3,
    m.previous_read,
    m.account_num AS account_number,
    m.low_limit,
    m.high_limit,
    m.low_usage,
    m.high_usage,
    m.calc_usage AS calculated_usage,
    m.num_dials,
    CONCAT(h.Date, h.Time, LPAD(h.time_seconds, 2, '0')) as date_time,
    c.utility,
    c.acct_owner AS account_owner,
    c.MeterCode AS meter_code,
    m.msg,
    c.misc1,
    c.misc2,
    c.misc3,
    c.active,
    c.backward,
    mcd.always_require_photo AS require_photo
FROM
    datazeo.meters AS m
    INNER JOIN datazeo.routes AS rt ON rt.id = m.route_id
    INNER JOIN info.loads AS l ON l.RouteID = rt.route
    INNER JOIN ${city.getString("DbName")}.custfile AS c ON c.IDnum = m.meter_num
    LEFT JOIN ${city.getString("DbName")}.acsreads AS r ON r.IDnum = c.IDnum
    LEFT JOIN ${city.getString("DbName")}.history AS h ON
        h.IDnum = c.IDnum
        AND h.Month = $month
    LEFT JOIN datazeo.meter_customer_data AS mcd ON mcd.meter_id = m.id
WHERE
    m.city_id = $cityId
    AND rt.city_id = $cityId
    AND l.CityID = "$paddedCityId"
    AND l.ReaderID = ${requestContext.user.id}
    AND r.IDnum IS NULL
    AND l.Recheck = 0
    AND (
        l.split = 0
        OR (
            m.sequence >= l.seq_start
            AND m.sequence <= l.seq_end
        )
)