import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<BlogPost>> map = new HashMap<>();
        map.put(2017, Arrays.asList(
                new BlogPost("title1", "author1", "Guide", 10),
                new BlogPost("title2", "author1", "News", 15),
                new BlogPost("title3", "author2", "News", 5),
                new BlogPost("title4", "author2", "Review", 10)
                ));
        map.put(2018, Arrays.asList(
                new BlogPost("title5", "author1", "Guide", 3),
                new BlogPost("title6", "author1", "News", 2),
                new BlogPost("title7", "author2", "News", 1),
                new BlogPost("title8", "author2", "Review", 11)
        ));

        System.out.println(map);

        Map<Integer, List<BlogPostGroup>> mapPostGroup = new HashMap<>();

       for (Map.Entry<Integer, List<BlogPost>> entry :map.entrySet()) {
           List<BlogPost> blogPosts = entry.getValue();

           Map<String, Integer> postsLikesSum = blogPosts.stream().collect(groupingBy(BlogPost::getAuthor, Collectors.summingInt(BlogPost::getLikes)));

           Map<String, String> postsTitles = blogPosts.stream().collect(groupingBy(BlogPost::getAuthor, mapping(BlogPost::getTitle, joining(","))));

           Map<String, String> postsTypes = blogPosts.stream().collect(groupingBy(BlogPost::getAuthor, mapping(BlogPost::getType, joining(","))));


           List<BlogPostGroup> blogPostGroups = new ArrayList<>();

           blogPosts.forEach(
                   p -> blogPostGroups.add(
                           new BlogPostGroup(
                                   postsTitles.get(p.getAuthor()),
                                   p.getAuthor(),
                                   postsTypes.get(p.getAuthor()),
                                   postsLikesSum.get(p.getAuthor())
                           )
                   )
           );

           // delete duplicates
           Set<BlogPostGroup> blogPostGroupSet = new HashSet<>(blogPostGroups);
           blogPostGroups.clear();
           blogPostGroups.addAll(blogPostGroupSet);
           // sort by likes DESC order    
           blogPostGroups.sort((p1, p2) -> p2.likes - p1.likes );

           mapPostGroup.put(entry.getKey(), blogPostGroups);
       }

        System.out.println(mapPostGroup);
    }
}