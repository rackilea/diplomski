while(true){ //!level.finished()
        String nextInput = sc.next();
        if (nextInput.equals("r")){
            Level a = (Level) moves.pop();
            level = new Level(a.toString());
            level.display();
            moves.push(level);
        }
        // It is possible that peek returns null (it's the case if the deque is empty)
        // but this should only be an hint
        Level b = (Level) moves.peek();
        level = new Level(b.toString());
        level.move(nextInput);
        level.display();
        moves.push(level);
    }