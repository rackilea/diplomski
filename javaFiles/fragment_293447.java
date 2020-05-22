import org.springframework.data.mongodb.core.aggregation.*;

ConditionalOperators.Cond isFifteen = ConditionalOperators.when(new Criteria("student_age").is(15))
   .then(1).otherwise(0);

ConditionalOperators.Cond notFifteen = ConditionalOperators.when(new Criteria("student_age").ne(15))
        .then(1).otherwise(0);

ConditionalOperators.Cond sumNotFifteen = ConditionalOperators.when(new Criteria("student_age").ne(15))
        .thenValueOf("student_age").otherwise(0);


GroupOperation groupStage =  Aggregation.group()
        .sum(isFifteen).as("countFifteen")
        .sum(notFifteen).as("countNotFifteen")
        .sum(sumNotFifteen).as("sumNotFifteen");

Aggregation aggregation = Aggregation.newAggregation(groupStage);