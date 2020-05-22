try {
    memory[count] = allProcesses[processIndex[index]+temp];
    } catch (Exception e) {
        System.out.println("Page Fault");
        Thread.sleep(2000);
        }