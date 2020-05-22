JBMC version 5.12 (cbmc-5.11-3477-gcd70727ed) 64-bit x86_64 linux
Parsing SampleClass.class

...

** Results:
[array-create-negative-size.1] Array size should be >= 0: SUCCESS
[array-create-negative-size.2] Array size should be >= 0: SUCCESS
[array-create-negative-size.3] Array size should be >= 0: SUCCESS
[array-create-negative-size.4] Array size should be >= 0: SUCCESS
[array-create-negative-size.5] Array size should be >= 0: SUCCESS
[array-create-negative-size.6] Array size should be >= 0: SUCCESS
[array-create-negative-size.7] Array size should be >= 0: SUCCESS
[array-create-negative-size.8] Array size should be >= 0: SUCCESS
[array-create-negative-size.9] Array size should be >= 0: SUCCESS
SampleClass.java function java::SampleClass.main:([Ljava/lang/String;)V
[java::SampleClass.main:([Ljava/lang/String;)V.null-pointer-exception.1] line 4 Null pointer check: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.array-index-out-of-bounds-high.5] line 4 Array index should be < length: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.array-index-out-of-bounds-high.2] line 4 Array index should be < length: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.null-pointer-exception.3] line 4 Null pointer check: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.array-index-out-of-bounds-low.3] line 4 Array index should be >= 0: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.array-index-out-of-bounds-high.3] line 4 Array index should be < length: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.null-pointer-exception.4] line 4 Null pointer check: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.array-index-out-of-bounds-low.4] line 4 Array index should be >= 0: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.array-index-out-of-bounds-high.4] line 4 Array index should be < length: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.null-pointer-exception.5] line 4 Null pointer check: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.1] line 4 no uncaught exception: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.array-index-out-of-bounds-low.5] line 4 Array index should be >= 0: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.array-create-negative-size.1] line 4 Array size should be >= 0: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.null-pointer-exception.2] line 4 Null pointer check: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.array-index-out-of-bounds-low.1] line 4 Array index should be >= 0: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.array-index-out-of-bounds-high.1] line 4 Array index should be < length: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.array-index-out-of-bounds-low.2] line 4 Array index should be >= 0: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.null-pointer-exception.6] line 5 Null pointer check: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.null-pointer-exception.7] line 6 Null pointer check: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.array-index-out-of-bounds-low.6] line 6 Array index should be >= 0: SUCCESS
[java::SampleClass.main:([Ljava/lang/String;)V.array-index-out-of-bounds-high.6] line 6 Array index should be < length: FAILURE
[java::SampleClass.main:([Ljava/lang/String;)V.null-pointer-exception.8] line 6 Null pointer check: SUCCESS

** 1 of 31 failed (2 iterations)
VERIFICATION FAILED