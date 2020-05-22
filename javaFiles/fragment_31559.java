SELECT rjd.refresh_job_identifier, MAX(rjd.refresh_job_start_time),
       COUNT(*) (FILTER WHERE record_status = 'PENDING') as Pending,
       COUNT(*) (FILTER WHERE record_status = 'SUCCESSFUL') as Successful,
       COUNT(*) (FILTER WHERE record_status = 'CANCELLED') as Cancelled,
       COUNT(*) (FILTER WHERE record_status = 'ERROR') as ERROR
FROM refresh_job_detail rjd
GROUP BY ROLLUP (rjd.refresh_job_identifier);