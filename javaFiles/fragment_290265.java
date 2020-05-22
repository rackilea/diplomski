SimpleDateFormat monthFormatter = new SimpleDateFormat("MMM");
Map<String, Double> moveMap = 
    moveTracking.stream()
                .collect(Collectors.groupingBy
                    (m -> monthFormatter.format(m.getTime()),
                     Collectors.summingDouble(MoveTrack::getMovementAmount)));