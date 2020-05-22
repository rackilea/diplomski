Criteria where = Criteria.where("AGE").ne(15);
Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(where),
                Aggregation.group()
                    .sum("student_age").as("totalAge")
                    .count().as("countOfStudentNot15YearsOld")
);