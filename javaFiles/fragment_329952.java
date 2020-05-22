@Test
    public void updateMovie() throws Exception {
        Movie movie = new Movie(2,"Lotr",0, "dir2", 2003);
        MovieDto movieDto = mock(MovieDto.class);

        // Added the following line
        movieDto.setMovie(movie);

        System.out.println(movie.toString());
        when(movieService.updateMovie(anyInt(), anyString(), anyInt(), anyString(), anyInt())).thenReturn(movie);
        Map<String, MovieDto> map = movieController.updateMovie(2, movieDto);
        System.out.println(map.toString());
        assertEquals("Title should be Lots", "Lotr", map.get("movie").getName());
    }