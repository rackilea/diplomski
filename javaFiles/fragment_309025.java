package com.moglix.netsuite.kafka;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import io.confluent.kafka.serializers.subject.TopicRecordNameStrategy;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ReviewsConsumerConfig
{

@Value( "${kafka.bootstrap-servers}" )
private String bootstrapServers;

@Value( "${kafka.schema-registry-url}" )
private String schemaRegistryUrl;

@Value( "${kafka.reviews.start-offset}" )
private String orderStartOffset;

@Value( "${kafka.reviews.max-poll-records}" )
private Integer maxPollRecords;

@Bean
public <T> ConcurrentKafkaListenerContainerFactory<String, T> kafkaListenerContainerFactory()
{
    ConcurrentKafkaListenerContainerFactory<String, T> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory( consumerFactory1() );
    factory.setBatchListener( true );
    factory.getContainerProperties().setAckMode( ContainerProperties.AckMode.MANUAL );
    factory.getContainerProperties().setSyncCommits( true );
    return factory;
}

@Bean
public <T> ConsumerFactory<String, T> consumerFactory1()
{
    return new DefaultKafkaConsumerFactory<>( consumerConfigs1() );
}

@Bean
public Map<String, Object> consumerConfigs1()
{
    Map<String, Object> props = new HashMap<>();
    props.put( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers );
    props.put( ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class );
    props.put( ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName() );
    props.put( ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, orderStartOffset );

    props.put( AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryUrl );
    props.put( KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true );
    props.put( KafkaAvroSerializerConfig.VALUE_SUBJECT_NAME_STRATEGY, TopicRecordNameStrategy.class.getName());// This is main line for my problem solution
    //props.put( SpecificAvroWithSchemaDeserializer.AVRO_VALUE_RECORD_TYPE, mysql.researchdb.institutes.Value.class );

    props.put( ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords );
    props.put( ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false );
    return props;
}

}