public static HashCode getHashCodeWithSha256(Map<StockKey, Set<ClientAssetPosition>> positions) 
{
    final Hasher hasher = Hashing.sha256().newHasher();

    final Iterable<StockKey> orderedKeys
        = Ordering.sortedCopy(positions.keySet());

    Iterable<ClientAssetPosition> orderedAssets;

    for (final StockKey key: orderedKeys) {
        hasher.putObject(key, STOCK_KEY_FUNNEL);

        orderedAssets = Ordering.sortedCopy(positions.get(key));

        for (final ClientAssetPosition asset: orderedAssets)
            hasher.putObject(asset, CLIENT_ASSET_POSITION_FUNNEL);
    }
    return hasher.hash();
}