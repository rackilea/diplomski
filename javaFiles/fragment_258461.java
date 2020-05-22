public class So44937295ApplicationTests {
    final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void manual() {
        final User user = new User();
        user.setId(42L);
        user.setUsername("John");
        user.setPassword("goof");

        final Category category = new Category();
        category.setId(23L);
        category.setName("Category 1");

        final PostDTO postDTO = new PostDTO();
        postDTO.setAuthor(modelMapper.map(user, ShortInfoUserDTO.class));
        postDTO.setCategory(modelMapper.map(category, CategoryDTO.class));

        assertEquals(user.getId(), postDTO.getAuthor().getId());
        assertEquals(user.getUsername(), postDTO.getAuthor().getUsername());

        assertEquals(category.getId(), postDTO.getCategory().getId());
        assertEquals(category.getName(), postDTO.getCategory().getName());
    }

    @Test
    public void auto() {
        final User user = new User();
        user.setId(42L);
        user.setUsername("John");
        user.setPassword("goof");

        final Category category = new Category();
        category.setId(23L);
        category.setName("Category 1");

        class Post {
            private User author;
            private Category category;
            // getters and setters
        }

        final Post post = new Post();
        post.setAuthor(user);
        post.setCategory(category);
        final PostDTO postDTO = modelMapper.map(post, PostDTO.class);

        assertEquals(post.getAuthor().getId(), postDTO.getAuthor().getId());
        assertEquals(post.getAuthor().getUsername(), postDTO.getAuthor().getUsername());

        assertEquals(post.getCategory().getId(), postDTO.getCategory().getId());
        assertEquals(post.getCategory().getName(), postDTO.getCategory().getName());
    }

    public static class PostDTO {
        private Long id;
        private ShortInfoUserDTO author;
        private CategoryDTO category;
        // getters and setters
    }

    public static class User {
        private Long id;
        private String username;
        private String password;
        // getters and setters
    }

    public static class ShortInfoUserDTO {
        private Long id;
        private String username;
        // getters and setters
    }

    public static class Category {
        private Long id;
        private String name;
        // getters and setters
    }

    public static class CategoryDTO {
        private Long id;
        private String name;
        // getters and setters
    }

}