if (event.getStartTime().isAfter(e.getStartTime())
                    && event.getStartTime().isBefore(e.getEndTime())) {
                overlap = true;

            } else if (event.getEndTime().isAfter(e.getStartTime())
                    && event.getEndTime().isBefore(e.getEndTime())) {
                overlap = true;
            }