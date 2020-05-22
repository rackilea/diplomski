SELECT
        DISTINCT movies.title
    FROM
        showtimes
        ,theaters
        ,movies
    WHERE
        movies.id = showtimes.movieID
        AND showtimes.theatreID = theatre.id
        AND theatre.city = 'LA';