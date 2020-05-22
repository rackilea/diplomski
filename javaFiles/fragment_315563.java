if (startTime.isAfter(endTime)) {
        if (targetTime.isBefore(endTime) || targetTime.isAfter(startTime)) {
            System.out.println("Yes! night shift.");
        } else {
            System.out.println("Not! night shift.");
        }
    } else {
        if (targetTime.isBefore(endTime) && targetTime.isAfter(startTime)) {
            System.out.println("Yes! without night shift.");
        } else {
            System.out.println("Not! without night shift.");
        }
    }