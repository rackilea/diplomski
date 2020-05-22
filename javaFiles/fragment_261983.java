;with cte as (
 Select *
       ,[NewPriority] = row_number() over (partition by [resouce] order by [Priority])
  From  YourTable
)
Update cte set [Priority]=[NewPriority]