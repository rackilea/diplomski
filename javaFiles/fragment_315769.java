if (this.currentState.equals(finalState)) { 
        System.out.println("Successful! Ending Time: " + startTime);
        System.out.println("Path back to start:");
        PuzzleState state = currentState;
        do {
          state.print();
          state = previous.get(state);
        } while (state != null);
    }