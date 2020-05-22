@Method(declaringClass = "matmul.files.MatmulImpl")
void multiplyAccumulative(
    @Parameter(direction = Direction.INOUT, type = Type.FILE) String file1,
    @Parameter() String file2,
    @Parameter() String file3,
    @Parameter() int bsize
);