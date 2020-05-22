List<TaskDTO> getAllProjectsTaskReport(){
log.info(" Service getAllProjectsTaskReport");

String sql="select id,sum(actual_effort) as actual_effort,actual_end_date,actual_start_date,code,created_date,description,name,sum(planned_effort) as planned_effort,planned_end_date,planned_start_date,status,work_completed_percent,assigned_to_id,created_by_id,parent_task_code_id,project_id from task group by project_id";

List<TaskDTO> list  = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(TaskDTO.class));
return list;
}