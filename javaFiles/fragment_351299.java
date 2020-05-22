test {
    afterTest { descriptor, result ->
        if (result.resultType == TestResult.ResultType.SKIPPED) {
            throw new GradleException("Do not ignore test cases")
        }
    }
}