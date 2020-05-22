SELECT  rjd.refresh_job_identifier, MAX(rjd.refresh_job_start_time),
        COALESCE(SUM(CASE WHEN record_status = 'PENDING' THEN 1 ELSE 0 END), 0) as Pending,
        COALESCE(SUM(CASE WHEN record_status = 'SUCCESSFUL' THEN 1 ELSE 0 END), 0) as Successful,
        COALESCE(SUM(CASE WHEN record_status = 'CANCELLED' THEN 1 ELSE 0 END), 0) as Cancelled,
        COALESCE(SUM(CASE WHEN record_status = 'ERROR' THEN 1 ELSE 0 END), 0) as ERROR
from refresh_job_detail rjd
group by rollup (rjd.refresh_job_identifier);