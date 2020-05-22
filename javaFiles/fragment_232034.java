switch (entity.getStatus()) {
        case READY: 
            new Task(entity).start();
            break;
        case RUNNING:
            // It is still running .. Have patience!
            break;
        case FINISHED:
            // It is finished!
            break;
    }