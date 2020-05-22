for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getClass() == (new Secretary().getClass()))
                output.writeObject(new Secretary((Secretary) all.get(i)));
            else if (all.get(i).getClass() == (new Supervisor().getClass()))
                output.writeObject(new Supervisor((Supervisor) all.get(i)));
            else
                output.writeObject(new Employee(all.get(i)));
        }