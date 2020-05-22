ProcessBuilder pb1 = new ProcessBuilder(
            "curl.exe",
            "-XPOST",
            "-H", "Content-Type:application/json",
            "http://localhost:8084/druid/v2/?pretty",
            "-d", "{\"queryType\":\"timeBoundary\",\"dataSource\":\"wikipedia\"}"

        );