final String regex = "(http://porter.com/request/).+";

/**
 * Below code will return false
 * since, URL doesn't have last path
 */
final String yourUrl = "http://porter.com/request/.*";
final boolean valid = yourUrl.matches(regex)

/**
 * Same (will return false), as ex. above
 */

final String yourUrl = "http://porter.com/request/*";
final boolean valid = yourUrl.matches(regex)

/**
 * This will return true. Link is Ok.
 */

final String yourUrl = "http://porter.com/request/tokenId";
final boolean valid = yourUrl.matches(regex)