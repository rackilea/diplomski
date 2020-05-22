SELECT 
    YEAR(`dateregistered`) AS `Year`,
    MONTH(`dateregistered`) AS `Month`,
    COUNT(`name`) AS `NumberRegistered`
FROM
    `User`
GROUP BY -- Since you want the values counted by year then month
    YEAR(`dateregistered`) AS `Year`,
    MONTH(`dateregistered`) AS `Month`
ORDER BY -- To order the actual results
    YEAR(`dateregistered`) AS `Year`,
    MONTH(`dateregistered`) AS `Month`;