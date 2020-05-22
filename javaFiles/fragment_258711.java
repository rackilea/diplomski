ProcessBuilder builder = new ProcessBuilder(
            "cmd",
            "/c",
            "(C:\\projects\\JavaAppCRLF\\test4.bat < C:\\projects\\JavaAppCRLF\\tmp-test4.in)",
            ">",
            "C:\\projects\\JavaAppCRLF\\tmp-test4.out"
    );