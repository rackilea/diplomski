cat.ifPresent(c -> {
            CurrentState currentState = c.findActiveCurrentState();
            Food food = foodService.find(c.getId());
            Outcome outCome = currentState.findByOutcomeId(currentState.getOutcomeId());

            if (outCome.getTypes().contains("Food")) {
                catService.eatFood(food);
            }
        });