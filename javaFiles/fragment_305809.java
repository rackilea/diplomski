TrainingplanExercise squats20 = trainingService.createExercise("Squats", "20");
TrainingplanExercise lifts10 = trainingService.createExercise("Lifts", "10");
TrainingplanExercise crunches50 = trainingService.createExercise("Crunches", "50");

TrainingPlan trainingPlan = trainingService.createTrainingPlan();
trainingPlan.getTrainingplanExercises().add( squats20 );
trainingPlan.getTrainingplanExercises().add( lifts10 );
trainingService.updateTrainingPlan(trainingPlan);

trainingPlan = trainingService.createTrainingPlan();
trainingPlan.getTrainingplanExercises().add( lifts10 );
trainingPlan.getTrainingplanExercises().add( crunches50 );
trainingService.updateTrainingPlan(trainingPlan);