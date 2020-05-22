new Timer().schedule(new TimerTask() {
    @Override
    public void run() {
        iteration++;
        for (Map.Entry<Integer,Long> entry : ping.entrySet()) {
            long oldIteration = entry.getValue();
            if (iteration-oldIteration > 5) {
                killIds.add(entry.getKey());
                ping.remove(entry.getKey());
            }
        }
    }
},200,200);