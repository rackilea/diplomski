/**
 * Request database info.
 *
 * @param requestItems
 *         Array of info items to request
 * @param bufferLength
 *         Response buffer length to use
 * @param infoProcessor
 *         Implementation of {@link InfoProcessor} to transform
 *         the info response
 * @return Transformed info response of type T
 * @throws SQLException
 *         For errors retrieving or transforming the response.
 */
<T> T getDatabaseInfo(byte[] requestItems, int bufferLength, InfoProcessor<T> infoProcessor) throws SQLException;