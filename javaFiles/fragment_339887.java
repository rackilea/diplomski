public static AlgorithmEnum getAlgorithm(final String algorithm)
        throws IllegalArgumentException
    {
        for (final AlgorithmEnum algorithmEnum : AlgorithmEnum.values())
        {
            if (algorithm.equalsIgnoreCase(String.format("%swith%s", algorithmEnum.getHashAlgorithm(), algorithmEnum.getKeyAlgorithm())))
            {
                return algorithmEnum;
            }
        }
        throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
    }