for (final long processId : processes)  {
        try {
            ProcCpu procCpu = sigar.getProcCpu(processId);
            // compare and set max value.
        } catch (SigarException e) {
            //In case for some pid access is denied.
        }

}