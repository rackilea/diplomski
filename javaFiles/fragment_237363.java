String[] tokens = inputString.split(" ");

actorId = Integer.valueOf(tokens[0]);
actorFirstName = tokens[1];
actorLastName = tokens[tokens.length - 2];
actorBirthYear = Integer.valueOf(tokens[tokens.length - 1]);